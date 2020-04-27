require 'test_helper'

class GreensTest < ActiveSupport::TestCase
  test "fixtures are saved" do
    assert_equal 2, Green.count
  end
  
  test "name is unique" do
    green = Green.new greens(:one).dup.serializable_hash
    assert_not green.valid?
  end
end
